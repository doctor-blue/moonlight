/**
 * Create by Nguyen Van Tan from Dev Comentry (07/2021)
 */
package com.devcomentry.moonlight.binding

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@DslMarker
@Retention(AnnotationRetention.BINARY)
internal annotation class BindingOnly