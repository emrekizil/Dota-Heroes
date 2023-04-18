package com.example.common

interface DotaMapper <I, O> {
    fun map(input:I?) : O
}