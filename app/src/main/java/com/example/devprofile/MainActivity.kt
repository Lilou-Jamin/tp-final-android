
package com.example.devprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.devprofile.ui.theme.DevProfileTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Button
import androidx.compose.foundation.clickable
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            DevProfileTheme {
                EcranProfil(
                    nom = "Lilou Jamin",
                    role = "Etudiante en master d'informatique",
                    description = "Passionnée par le développement web, je souhaite devenir développeuse fullstack ",
                    competences = listOf("VueJS","Node", "Python"),
                    disponibilite = "Disponible pour une alternance",
                )
            }
        }

    }
}

@Composable
fun EcranProfil(nom: String, role: String, description: String, competences: List<String>, disponibilite: String, modifier: Modifier = Modifier) {
    FicheProfil(
        nom = nom,
        role = role,
        description = description,
        competences = competences,
        disponibilite = disponibilite,
        onContactClick = {},
        onDisponibiliteClick = {},
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun EnteteProfil(nom: String, role: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(text = nom)
        Text(text = role)
    }
}

@Composable
fun DescriptionProfil(description: String, modifier: Modifier = Modifier) {
    Text(text = description, modifier = modifier.padding(8.dp))
}

@Composable
fun CompetenceProfil(competence: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(text = "• $competence", modifier = Modifier.padding(12.dp))
    }
}

@Composable
fun DisponibiliteProfil(
    disponibilite: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .semantics {
                contentDescription = "Consulter la disponibilité : $disponibilite"
            }
            .clickable(
                role = Role.Button,
                onClick = onClick
            )
    ) {
        Text(
            text = disponibilite,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ActionProfil(texte: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = texte)
    }
}


@Composable
fun FicheProfil(nom: String, role: String, description: String, competences: List<String>, disponibilite: String, onContactClick: () -> Unit, onDisponibiliteClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        EnteteProfil(nom = nom, role = role)
        DescriptionProfil(description = description)
        Text(text = "Mes compétences", modifier = Modifier.padding(8.dp))

        for (competence in competences) {
            CompetenceProfil(competence = competence)
        }

        DisponibiliteProfil(
            disponibilite = disponibilite,
            onClick = onDisponibiliteClick,
            modifier = Modifier.padding(8.dp)
        )
        ActionProfil(texte = "Me contacter", onClick = onContactClick, modifier = Modifier.padding(8.dp))
    }
}

@Preview(
    name = "Profil Android Junior",
    showBackground = true
)
@Composable
fun PreviewProfilAndroid() {
    DevProfileTheme {
        EcranProfil(
            nom = "Alex Martin",
            role = "Développeur Android Junior",
            description = "Passionné par le développement mobile, " +
                    "je crée des applications Android simples et accessibles.",
            competences = listOf(
                "Kotlin",
                "Jetpack Compose",
                "Git / GitHub"
            ),
            disponibilite = "Disponible pour une alternance"
        )
    }
}

@Preview(
    name = "Profil Full-Stack",
    showBackground = true
)
@Composable
fun PreviewProfilFullStack() {
    DevProfileTheme {
        EcranProfil(
            nom = "Gabriel DUPONT",
            role = "Développeur android",
            description = "Spécialisé en développement d'applictations mobiles, je crée des applications modernes et performantes",
            competences = listOf("Kotlin", "Java","Android Studio"),
            disponibilite = "Embauché chez Google"
        )
    }
}