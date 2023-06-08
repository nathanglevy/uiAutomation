package processor

import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ksp.addOriginatingKSFile
import com.squareup.kotlinpoet.ksp.writeTo

fun <T:Any,S:Any> T.applyNotNull(nullable:S?, block : T.(S) -> T) : T {
    return if (nullable == null) return this
    else this.block(nullable)
}

class AutoGenUIClassVisitor(val ctx: UISymbolProcessorContext) : KSVisitorVoid() {
    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        ctx.logger.warn(
            classDeclaration.packageName.getShortName() + "." +
                    classDeclaration.simpleName.getShortName())
        val composableBlock = FunSpec.builder(
            MemberName(
                packageName = classDeclaration.packageName.getShortName(),
                simpleName = classDeclaration.simpleName.getShortName()+"Composable"
            ))
            .addAnnotation(ClassName("androidx.compose.runtime","Composable"))
            .addComment("EmptyBody")
            .applyNotNull(classDeclaration.containingFile) {
                addOriginatingKSFile(it)
            }
            .build()

        FileSpec.builder(
            packageName = classDeclaration.packageName.getShortName(),
            classDeclaration.simpleName.getShortName()+"Composable"
        ).addFunction(composableBlock).build().writeTo(ctx.codeGenerator,aggregating = false)
    }
}