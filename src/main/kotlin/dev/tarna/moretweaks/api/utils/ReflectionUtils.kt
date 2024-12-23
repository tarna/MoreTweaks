package dev.tarna.moretweaks.api.utils

import dev.tarna.moretweaks.api.commands.TweakCommand
import org.reflections.Reflections

object ReflectionUtils {
    inline fun <reified T : Any> getClassesOfType(packageName: String): Set<T> {
        val reflections = Reflections(packageName)
        return reflections.getSubTypesOf(T::class.java).map { it.getDeclaredConstructor().newInstance() }.toSet()
    }

    inline fun <reified T : Any> getCommandClasses(packageName: String): Set<T> {
        val reflections = Reflections(packageName)
        return reflections.getSubTypesOf(T::class.java)
            .filterNot { TweakCommand::class.java.isAssignableFrom(it) }
            .map { it.getDeclaredConstructor().newInstance() }.toSet()
    }
}