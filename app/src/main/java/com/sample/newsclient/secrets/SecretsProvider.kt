package com.sample.newsclient.secrets

interface SecretsProvider {

    fun provideNewsApiKey():String

}