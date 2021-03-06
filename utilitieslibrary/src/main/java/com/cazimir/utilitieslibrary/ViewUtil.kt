package com.cazimir.utilitieslibrary

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/*text change listener for edittext
* Usage:
* form.combo_name.onChange {
            comboNameString.value = it --> populate a liveData Observabel to react to changes
        }
*
* */
fun EditText.onChange(cb: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            cb(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}