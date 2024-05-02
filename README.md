# Automatic_Stroke_Prediction_using_android

## Overview
This project aims to develop an Android application for predicting the likelihood of stroke based on various health parameters. The prediction model is built using machine learning techniques, particularly artificial neural networks (ANN), and is deployed on the Android platform for user interaction.  

![enter image description here](https://github.com/jahirnstu14/Automatic_Stroke_Prediction_using_android/blob/main/titlepic.jpg)

## Workflow

### Model Development
The prediction model is developed using Python in a Jupyter Notebook environment. The following steps are executed to create the model:

- **Load Python Modules/Packages**: Necessary Python libraries are imported for data manipulation, model training, and evaluation.
- **Load Dataset**: The dataset containing health parameters such as age, hypertension, heart disease, etc., is loaded into the notebook.
- **Data Preprocessing**:
  - *Missing Data Handling*: Any missing values in the dataset are filled using forward-fill method to maintain data integrity.
  - *Column Removal*: Irrelevant columns like 'id' are removed from the dataset.
  - *Categorical Encoding*: Categorical variables are encoded using ordinal encoding for numerical representation.
- **Dataset Splitting**: The dataset is split into training and testing sets for model evaluation.
- **Data Balancing**: The dataset is balanced using the Synthetic Minority Over-sampling Technique (SMOTE) to handle class imbalance.
- **Model Training**: An artificial neural network (ANN) is implemented using the Keras library. The model architecture consists of multiple layers with appropriate activation functions.
- **Model Evaluation**: The trained model is evaluated using performance metrics such as accuracy, precision, recall, and F1-score.
   
[Model creation  using Google Colab](https://colab.research.google.com/drive/1WdS-fr28W57-I4QUIlE4NK-wNk0B3Eku)

### Model Deployment
Once the model is trained and evaluated satisfactorily, it is converted into the TensorFlow Lite (TFLite) format for deployment on the Android platform.

### Android App Development
The Android application is developed using java  programming languages and integrated with the TFLite model for stroke prediction. The app provides a user-friendly interface for inputting health parameters and receiving predictions.

![Start Page : ](https://github.com/jahirnstu14/Automatic_Stroke_Prediction_using_android/blob/main/1.startPage.PNG)  

![User Input 1 :](https://github.com/jahirnstu14/Automatic_Stroke_Prediction_using_android/blob/main/2.DataInput1.PNG)![User Input 2 :](https://github.com/jahirnstu14/Automatic_Stroke_Prediction_using_android/blob/main/2.DataInput2.PNG)  

![Stroke Status ](https://github.com/jahirnstu14/Automatic_Stroke_Prediction_using_android/blob/main/3.Strokepatient%20suggestion.PNG)![enter image description here](https://github.com/jahirnstu14/Automatic_Stroke_Prediction_using_android/blob/main/4.nonstrokepatientstaus.PNG)

 - 
