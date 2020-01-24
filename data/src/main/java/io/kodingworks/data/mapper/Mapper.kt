package io.kodingworks.data.mapper

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */

interface EntityMapper<E, D> {
    fun mapToDomain(type: E): D
}