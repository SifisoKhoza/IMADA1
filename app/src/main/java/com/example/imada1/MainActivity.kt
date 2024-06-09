package com.example.imada1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //global variables declaration
    private lateinit var resultTextView: TextView
    private lateinit var inputAgeEditText: EditText
    private lateinit var generateButton1: Button
    private lateinit var clearButton2: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initialisation of variables
        resultTextView = findViewById(R.id.resultTextView)
        inputAgeEditText = findViewById(R.id.inputAgeEditText)
        generateButton1 = findViewById(R.id.generateButton1)
        clearButton2 = findViewById(R.id.clearButton2)
        
        //the listener method is called to actionize the generate button
        generateButton1.setOnClickListener {
            /*the user input element 'inputAgeEditText' is converted to
        call 'isNullOrEmpty'*/
            if (inputAgeEditText.text.isNullOrEmpty()) {
                //if statement condition true then user is prompted to enter age
                inputAgeEditText.setText("Enter age")
                
            } else {
                /*variable is declared in else statement to
                 convert inputAgeEditText from int to string
                 */
                val age: Int = inputAgeEditText.text.toString().toIntOrNull() ?: -1
                /*value for errormessage variable is declared for the string
                */
                val errorMessage = "Please Enter another age between 19 and 100"
                /*if statement is issued whereby the condition is if the user input age is between 19 and 100
                    then a matching message should be displayed as string from a the declared
                    variable 'matchingMessage'
                 */
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
                        /*if the if statements conditions are not met then the
                        else statement is called being the errormessage containing
                        the string that was stored in it.*/
                        else -> errorMessage
                    }
                    /*
                    if statement conditions are if the matching message is not equal to
                    previous else statement then a result string text will be displayed.
                   */
                    if (matchingMessage != errorMessage) {
                        resultTextView.text = "You match with $matchingMessage"
                    } else {
                        /*if the matching message is equal to the errormessasge
                     then user will be prompted*/
                        resultTextView.text = errorMessage
                    }
                } else {
                    resultTextView.text = errorMessage
                }
            }
        }
        /*the listener method is called to clear inout stored by user when
        clicking the clear button*/
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
    //the validate function to validate if user input is the number between 19 and 100
    private fun validateInput(age: Int): Boolean {
        return if (age in 19..100) {
            true
        } else {
            println("Invalid. Enter age")
            false
        }
    }
}
