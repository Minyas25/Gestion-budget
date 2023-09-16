package com.example.gestion_budget

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class AddBudgetActivity: AppCompatActivity() {
    // Déclarez les éléments d'interface utilisateur
    private lateinit var editTextBudgetName: EditText
    private lateinit var editTextBudgetAmount: EditText
    private lateinit var buttonSaveBudget: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_budget)

        // Récupérez les éléments d'interface utilisateur à partir de la mise en page XML
        editTextBudgetName = findViewById(R.id.editTextBudgetName)
        editTextBudgetAmount = findViewById(R.id.editTextBudgetAmount)
        buttonSaveBudget = findViewById(R.id.buttonSaveBudget)

        // Référence à la base de données Firebase
        val database = FirebaseDatabase.getInstance()
        val budgetRef = database.getReference("budgets")

        // Ajoutez une logique pour le bouton "Enregistrer"
        buttonSaveBudget.setOnClickListener {
            val budgetName = editTextBudgetName.text.toString()
            val budgetAmount = editTextBudgetAmount.text.toString()

            // Validez les entrées utilisateur (vérifiez si les champs sont vides, si les valeurs sont valides, etc.)
            if (budgetName.isNotBlank() && budgetAmount.isNotBlank()) {
                // Créez un nouvel objet Budget avec les données saisies par l'utilisateur
                val budget = Budget(budgetName, budgetAmount.toDouble())

                // Enregistrez le budget dans la base de données Firebase
                val budgetId = budgetRef.push().key
                budgetId?.let {
                    budgetRef.child(it).setValue(budget)
                }

                // Affichez un message de confirmation
                Toast.makeText(this, "Budget enregistré avec succès", Toast.LENGTH_SHORT).show()

                // Terminez cette activité et retournez à l'activité précédente (par exemple, MainActivity)
                finish()
            } else {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            }

        }
    }

}

