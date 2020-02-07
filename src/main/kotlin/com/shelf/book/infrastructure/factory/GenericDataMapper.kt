package com.shelf.book.infrastructure.factory

import com.shelf.book.infrastructure.factory.exceptions.GenericDataMapperException
import org.springframework.beans.BeanUtils
import java.lang.Exception

object GenericDataMapper{

    // If this functions fails to map, it should throw a custom generic mapper exception
    @Throws(GenericDataMapperException::class)
    fun <TargetClass> map(source: Any, target: Class<TargetClass>): TargetClass{
        try {
            // The getConstructor method shall return the constructor of the target class
            // This is necessary because it also considers data classes which have primary constructors
            val domainObjectInstance = target.getConstructor().newInstance()
            this.copyProperties(domainObjectInstance!!, source)
            return domainObjectInstance
        } catch (ex: Exception){
            val message = "Unexpected failure while mapping properties from ${source::class.java.name} to ${target.name}" +
                    "with message ${ex.message}"
            throw GenericDataMapperException(message, ex.cause)
        }
    }

    private fun copyProperties(source: Any, target: Any){
        BeanUtils.copyProperties(target, source)
    }

}