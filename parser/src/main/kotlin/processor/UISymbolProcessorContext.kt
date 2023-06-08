package processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger

data class UISymbolProcessorContext(
    val codeGenerator: CodeGenerator,
    val logger: KSPLogger
)

//fun SymbolProcessorEnvironment