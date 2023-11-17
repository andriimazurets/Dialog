package com.example.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val addContactDialog = AlertDialog.Builder(this).setTitle("Add contact")
            .setMessage("Do you want to add contact to your contact list?")
            .setIcon(R.drawable.ic_add_contact).setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You added contact to your contact list", Toast.LENGTH_SHORT)
                    .show()
            }.setNegativeButton("No") { _, _ ->
                Toast.makeText(
                    this, "You didn't add contact to your contact list", Toast.LENGTH_SHORT
                ).show()
            }.create()

        binding.btnCallDialogOne.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("First item", "Second item", "Third item")
        val singleChoiceDialog = AlertDialog.Builder(this).setTitle("Choose one of these options")
            .setSingleChoiceItems(options, 0) { dialogInterface, i ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }.setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }.setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined  the SingleChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }.create()

        binding.btnCallDialogTwo.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this).setTitle("Choose one of these options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if (isChecked) Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT)
                    .show()
                else Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
            }.setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted the MultiChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }.setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined  the MultiChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }.create()
        binding.btnCallDialogThree.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}