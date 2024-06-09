package com.example.imada1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var inputAgeEditText: EditText
    private lateinit var generateButton1: Button
    private lateinit var clearButton2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
        inputAgeEditText = findViewById(R.id.inputAgeEditText)
        generateButton1 = findViewById(R.id.generateButton1)
        clearButton2 = findViewById(R.id.clearButton2)

        generateButton1.setOnClickListener {
            if (inputAgeEditText.text.isNullOrEmpty()) {
                inputAgeEditText.setText("Enter age")
            } else {
                val age: Int = inputAgeEditText.text.toString().toIntOrNull() ?: -1
                val errorMessage = "Please Enter another age between 19 and 100"

                if (age in 19..100) {
                    val matchingMessage: String = when (age) {
                        95 -> """
                            Nelson Mandela (1918-2013)-Died at 95.
                            South African anti-apartheid revolutionary
                            and president
                        """.trimIndent()
                        87 -> """
                            Mother Teresa (1910-1997)-Died at 87.
                            Roman catholic nun and missionary
                        """.trimIndent()
                        76 -> """
                            Albert Einstein (1879-1955)-Died at 76.
                            Theoretical physicist who developed the
                            theory of relativity
                        """.trimIndent()
                        39 -> """
                            Malcolm X (1925-1965)-Died at 39.
                            African-American Muslim minister and
                            human rights activist
                        """.trimIndent()
                        19 -> """
                            Joan of Arc (1412-1439)-Died at 19.
                            French heroine and Roman Catholic saint
                            who led the French army to victory during
                            the 'Hundred Years' War.
                        """.trimIndent()
                        30 -> """
                            Emily Bronte (1818-1848)-Died at 30.
                            English novelist and poet, best known
                            for 'Wuthering Heights'.
                        """.trimIndent()
                        32 -> """
                            Alexander the Great (356-323 BC)-Died at 32.
                            Conqueror and king of Macedonia, he created
                            one of the largest empires in history.
                        """.trimIndent()
                        67 -> """
                            Leonardo Da Vinci (1452-1519)-Died at 67.
                            Italian polymath of the Renaissance, known for
                            works such as 'Mona Lisa' and 'The Last Supper'.
                        """.trimIndent()
                        78 -> """
                            Mahatma Gandhi (1869-1948)-Died at 78.
                            Leader of the Indian independence movement
                            against British rule.
                        """.trimIndent()
                        53 -> """
                            Samora Machel (1933-1986)-Died at 53.
                            The first president of Mozambique and leader
                            in the fight against Portuguese colonial rule
                            and played a central role in the country's
                            independence.
                        """.trimIndent()
                        else -> errorMessage
                    }
                    if (matchingMessage != errorMessage) {
                        resultTextView.text = "You match with $matchingMessage"
                    } else {
                        resultTextView.text = errorMessage
                    }
                } else {
                    resultTextView.text = errorMessage
                }
            }
        }

        clearButton2.setOnClickListener {
            resultTextView.text = ""
            inputAgeEditText.text.clear()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }

    private fun enableEdgeToEdge() {
        // Implementation of this method
    }

    private fun validateInput(age: Int): Boolean {
        return if (age in 19..100) {
            true
        } else {
            println("Invalid. Enter age")
            false
        }
    }
}
