package com.example.common.mapper

interface HeroMapper <I, O> {
    fun map(input:I?) : O
}