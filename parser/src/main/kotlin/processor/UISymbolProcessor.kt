package processor

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated

class UISymbolProcessor(
    val ctx: UISymbolProcessorContext
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val autoGenUIClassVisitor = AutoGenUIClassVisitor(ctx)
        resolver.getSymbolsWithAnnotation("ui.annotation.AutogenUI").forEach {
            ctx.logger.warn("annotated class found")
            it.accept(autoGenUIClassVisitor, Unit)
        }
        return emptyList()
//        TODO("Not yet implemented")
    }
}