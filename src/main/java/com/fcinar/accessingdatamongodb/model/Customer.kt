package com.fcinar.accessingdatamongodb.model

import org.springframework.data.annotation.Id

data class Customer(
    @Id
    val id: String?,
    val name: String,
    val surname: String,
) {
    constructor(name: String, surname: String) : this(
        id = null,
        name = name,
        surname = surname
    )

    override fun toString(): String {
        return String.format(
            "Customer[id=%s, name='%s', surname='%s']",
            id, name, surname
        );
    }
}
