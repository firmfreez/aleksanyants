package com.firmfreez.android.developerslife.exceptions

import com.firmfreez.android.developerslife.exceptions.NetworkResponseException
import okhttp3.Response

class WrongResponseCodeException(message: String, displayedMessage: String? = null, response: Response? = null): NetworkResponseException(message, displayedMessage, response)
