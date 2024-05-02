package com.example.strokeprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SecondActivity extends AppCompatActivity {
    private Button button2,button3;
//    for spinner
    String[] option1work,option2work,option3work,option4work,option5work;
//    for first fivetextfield
    public EditText editText1,editText2,editText3,editText4,editText5;
    String editText1string,editText2string,editText3string,editText4string,editText5string;
    float age,hypertension,heartDisease,average_Gluclose,bmi;
    public TextView textView;
//    for spinner
    public Spinner spinner1,spinner2,spinner3,spinner4,spinner5;


    private Interpreter interpreter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button2 = findViewById(R.id.button2);
//        for identifying five textview
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);
        editText5=findViewById(R.id.editText5);

        //spinner1 work start
        option1work=getResources().getStringArray(R.array.options_array1);
        spinner1=findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.sample_layout,R.id.textviewsample,option1work);
        spinner1.setAdapter(adapter1);

        //spinner2 adaptar
        option2work=getResources().getStringArray(R.array.options_array2);
        spinner2=findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,R.layout.sample_layout,R.id.textviewsample,option2work);
        spinner2.setAdapter(adapter2);
//        spinner3 adapter
        option3work=getResources().getStringArray(R.array.options_array3);
        spinner3=findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(this,R.layout.sample_layout,R.id.textviewsample,option3work);
        spinner3.setAdapter(adapter3);
//        spinner4 adapter
        option4work=getResources().getStringArray(R.array.options_array4);
        spinner4=findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter4=new ArrayAdapter<String>(this,R.layout.sample_layout,R.id.textviewsample,option4work);
        spinner4.setAdapter(adapter4);
//        spinner5 adapter
        option5work=getResources().getStringArray(R.array.options_array5);
        spinner5=findViewById(R.id.spinner5);
        ArrayAdapter<String> adapter5=new ArrayAdapter<String>(this,R.layout.sample_layout,R.id.textviewsample,option5work);
        spinner5.setAdapter(adapter5);

//        for checking the spinner output creating third button
//        button3=findViewById(R.id.button3);
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            public float convertTosmokingstatus(String value) {
//                float smoking;
//
//                if ("Never Smoked".equals(value)) {
//                    smoking = 0;
//                }
//                else if ("formerly smoked".equals(value)) {
//                    smoking=1;
//
//                }
//                else if ("Smokes".equals(value)) {
//                    smoking=2;
//
//                }
//                else {
//                    smoking=3;
//                }
//
//                return smoking;
//            }
//            @Override
//            public void onClick(View v) {
//                float smokingstatus;
//                String value = spinner5.getSelectedItem().toString();
//                 smokingstatus = convertTosmokingstatus(value);
//
//
//                Toast.makeText(SecondActivity.this, "Selected Value: " + smokingstatus, Toast.LENGTH_LONG).show();
//            }
//        });

//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//                editText1string=editText1.getText().toString();
//                try {
//
//                    age=Float.parseFloat(editText1string);
//                    Toast.makeText(SecondActivity.this,editText1string, Toast.LENGTH_LONG).show();
//                }
//                catch (Exception e){
//                    Log log = null;
//                    log.e("logtag","Exception "+e.toString());}


//        for file loading start

        try {
            interpreter = new Interpreter(loadModelFile());
        } catch (IOException e) {
            e.printStackTrace();
        }


        button2.setOnClickListener(new View.OnClickListener() {
            public float convertToWorkType(String value) {
                float worktype;

                if ("Private".equals(value)) {
                    worktype = 3;
                } else if ("Self-employed".equals(value)) {
                    worktype = 2;
                } else if ("children".equals(value)) {
                    worktype = 0;
                } else if ("Govt_job".equals(value)) {
                    worktype = 1;
                } else {
                    worktype = 4;
                }

                return worktype;
            }
//            spinner2
            public float convertTogender(String value) {
                float gender;

                if ("Female".equals(value)) {
                    gender = 0;
                } else if ("Male".equals(value)) {
                    gender = 1;
                }  else {
                    gender = 2;
                }

                return gender;
            }
//spinner3
            public float convertToevermarried(String value) {
                float gender;

                if ("No".equals(value)) {
                    gender = 0;
                }  else {
                    gender = 1;
                }

                return gender;
            }
//spinner4
            public float convertToresidencetype(String value) {
                float residence;

                if ("Urban".equals(value)) {
                    residence = 0;
                }  else {
                    residence = 1;
                }

                return residence;
            }
//            spinner5
            public float convertTosmokingstatus(String value) {
                float smoking;

                if ("Never Smoked".equals(value)) {
                    smoking = 0;
                }
                else if ("formerly smoked".equals(value)) {
                    smoking=1;

                }
                else if ("Smokes".equals(value)) {
                    smoking=2;

                }
                else {
                    smoking=3;
                }

                return smoking;
            }



            @Override
            public void onClick(View v) {
                editText1string=editText1.getText().toString();
                editText2string=editText2.getText().toString();
                editText3string=editText3.getText().toString();
                editText4string=editText4.getText().toString();
                editText5string=editText5.getText().toString();

//five edit text variable
                age=Float.parseFloat(editText1string);
                hypertension=Float.parseFloat(editText2string);
                heartDisease=Float.parseFloat(editText3string);
                average_Gluclose=Float.parseFloat(editText4string);
                bmi=Float.parseFloat(editText5string);
//                spinner1
                float worktype;
              String value=spinner1.getSelectedItem().toString();
              worktype = convertToWorkType(value);
//              spinner2
                float gender;
                String value2 = spinner2.getSelectedItem().toString();
                gender = convertTogender(value2);
//                spinner3
                float evermarried;
                String value3 = spinner3.getSelectedItem().toString();
                evermarried = convertToevermarried(value3);
//                spinner4
                float residencetype;
                String value4 = spinner4.getSelectedItem().toString();
                residencetype = convertToresidencetype(value4);
//                spinner5
                float smokingstatus;
                String value5 = spinner5.getSelectedItem().toString();
                smokingstatus = convertTosmokingstatus(value5);

                float[] input = {gender, age, hypertension,heartDisease, evermarried,worktype, residencetype,average_Gluclose,bmi, smokingstatus};//(not free form stroke)
//              float[] input = {1.0f, 67.0f, 0.0f, 1.0f, 1.0f, 2.0f, 1.0f, 228.69f, 36.6f, 1.0f};(not free form stroke)
//                float[] input={0f, 80.0f, 0f, 0f, 1f, 2f,1f, 20f, 24.0f, 0f};//free from stroke

                float output = doInference(input);
                long prediction = Math.round(output);
                if (prediction == 1) {
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(intent);
                } else {
                    notshowAlertDialog();
                }
            }
        });
    }

    private void notshowAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // Set the title and message for the AlertDialog
        alertDialogBuilder.setTitle("Warning");
        alertDialogBuilder.setMessage("You are  free from stroke.");

        // Set the positive button and its click listener
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Close the dialog if the user clicks "OK"
                dialog.dismiss();
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    private ByteBuffer loadModelFile() throws IOException {
        AssetFileDescriptor assetFileDescriptor = this.getAssets().openFd("Stroke_Prediction.tflite");
        FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
        FileChannel fileChannel = fileInputStream.getChannel();

        long startOffset = assetFileDescriptor.getStartOffset();
        long length = assetFileDescriptor.getLength();

        ByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, length);
        fileInputStream.close(); // Close the FileInputStream after mapping

        return buffer;
    }

    public float doInference(float[] input) {
        float[][] output = new float[1][1];
        interpreter.run(input, output);
        return output[0][0];
    }
}
