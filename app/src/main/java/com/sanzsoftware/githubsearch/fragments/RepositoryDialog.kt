package com.sanzsoftware.githubsearch.fragments

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.sanzsoftware.githubsearch.R
import com.sanzsoftware.githubsearch.models.Repository
import com.sanzsoftware.superapp.transforms.CircleTransform
import com.squareup.picasso.Picasso
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
                startActivity(Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(repository.htmlUrl)
                })
            }

            user_button.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(repository.owner.url)
                })
            }

            Picasso.get()
                .load(repository.owner.avatarUrl)
                .resize(80, 80)
                .transform(CircleTransform())
                .centerCrop()
                .into(user_icon_imageView)
        }
    }

}