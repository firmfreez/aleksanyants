package com.firmfreez.android.developerslife.exceptions

import com.firmfreez.android.developerslife.utils.AppContext
import java.lang.Exception

open class AppException(message: String, override val displayedMessage: String? = null): Exception(message),
    DisplayedMessageExceptionInterface {
    constructor(message: String, displayedMessage: Int? = null): this(message, AppContext.getString(displayedMessage))
}