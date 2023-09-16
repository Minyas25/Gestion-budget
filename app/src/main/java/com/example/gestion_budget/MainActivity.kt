package com.example.gestion_budget

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_budget.ui.theme.Gestion_budgetTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {

    private lateinit var textViewTitle: TextView
    private lateinit var recyclerViewBudgets: RecyclerView
    private lateinit var buttonAddBudget: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_main)
        // Récupérez les éléments d'interface utilisateur à partir de la mise en page XML
        textViewTitle = findViewById(R.id.textViewTitle)
        recyclerViewBudgets = findViewById(R.id.recyclerViewBudgets)
        buttonAddBudget = findViewById(R.id.buttonAddBudget)

        // Configurez la RecyclerView (créer un adaptateur et gérer les clics ici)

        // Ajoutez une logique pour le bouton "Ajouter un budget"
        buttonAddBudget.setOnClickListener {
            // Ajoutez ici la logique pour gérer le clic sur le bouton
            // Par exemple, ouvrez une nouvelle activité pour ajouter un budget
            val intent = Intent(this, AddBudgetActivity::class.java)
            // Lancez l'activité d'ajout de budget
            startActivity(intent)
        }
    }

    fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.menu_dropdown, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_item_1 -> {
                    true
                }
                R.id.menu_item_2 -> {
                    true
                }
                R.id.menu_item_3 -> {
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Gestion_budgetTheme {
        Greeting("Android")
    }
}

