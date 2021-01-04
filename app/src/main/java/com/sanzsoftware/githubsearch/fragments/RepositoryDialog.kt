package com.sanzsoftware.githubsearch.fragments

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.sanzsoftware.githubsearch.R
import com.sanzsoftware.githubsearch.models.Repository
import kotlinx.android.synthetic.main.repository_dialog.*
import kotlinx.android.synthetic.main.repository_dialog.repository_button
import kotlinx.android.synthetic.main.repository_dialog.repository_description_dialog_textView
import kotlinx.android.synthetic.main.repository_dialog.repository_name_dialog_textView
import kotlinx.android.synthetic.main.repository_dialog.view.*


class RepositoryDialog(private val repository: Repository) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.repository_dialog ,container, false).apply {
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

            repository_description_dialog_textView.apply {
                text = repository.description
                movementMethod = ScrollingMovementMethod()
            }

            repository_name_dialog_textView.text = repository.name
            user_name_dialog_textView.text = repository.owner.login

            repository_button.setOnClickListener {
                Toast.makeText(this.context, repository.htmlUrl, Toast.LENGTH_SHORT).show()
            }

            user_button.setOnClickListener {
              Toast.makeText(this.context, repository.owner.url, Toast.LENGTH_SHORT).show()
            }

            /*
            Picasso.get()
                .load(character.thumbnail?.path + "."  + character.thumbnail?.extension)
                .resize(100, 100)
                .transform(CircleTransform())
                .centerCrop()
                .into(imageViewDialog)
             */

        }
    }

}