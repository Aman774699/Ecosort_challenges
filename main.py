import streamlit as st
import tensorflow as tf
import numpy as np
st.markdown(
    """
    <style>
    body {
        background-color: #37FF92;
    }
    </style>
    """,
    unsafe_allow_html=True
)

# Tensorflow Model Prediction
def model_prediction(test_image):
    model = tf.keras.models.load_model("Amantrained_model.h5")
    image = tf.keras.preprocessing.image.load_img(test_image, target_size=(64, 64))
    input_arr = tf.keras.preprocessing.image.img_to_array(image)
    input_arr = np.array([input_arr])  # convert single image to batch
    predictions = model.predict(input_arr)
    return np.argmax(predictions)  # return index of max element

# Sidebar
st.sidebar.title("Dashboard")
app_mode = st.sidebar.selectbox("Select Page", ["Prediction", "About Project", "Home"])

# Main Page
if app_mode == "Prediction":
    st.header("Check Wheather the Item is Recyclable or Not")
    test_image = st.file_uploader("Choose an Image:")
    if st.button("Show Image") and test_image is not None:
        st.image(test_image, width=300, use_column_width=True)
    # Predict button
    if st.button("Predict") and test_image is not None:
        st.write("Our Prediction")
        result_index = model_prediction(test_image)
        # Reading Labels
        with open("labelfinal.txt") as f:
            content = f.readlines()
        label = [i.strip() for i in content]
        class_name = label[result_index]
        # st.success(f"Model is Predicting it has a {class_name} Product Hence...")
        if class_name in ["plastic","cardboard","green-glass","paper","Metal"]:
            st.success("It is a Recyclable item")
            st.success("Tap the below button to recycle your item")
            st.markdown("[Click here to recycle](http://localhost:8080/mavenproject1/Final_recycling_process.jsp)")
        else:
            st.success("It is non-recycable item")

if app_mode=="About Project":
    st.header("About Our Project Discription")
    st.write("The purpose of the Waste Sorting and Recycling Gamification App is to transform the often mundane task of waste sorting and recycling into an enjoyable and rewarding experience. By gamifying the process and providing users with educational resources and incentives, the app aims to increase recycling participation rates, reduce contamination in recycling streams, and ultimately contribute to a cleaner and more sustainable environment.")
    st.write("The app is developed using Java for core logic implementation, JDBC for backend development,DataScience For model Predicting and simulation of API requests. Additionally, image recognition technology may be integrated using libraries such as OpenCV to enable real-time identification of recyclable items from images captured by users.")

if app_mode=="Home":
     st.markdown("[Click here to go to the Home page](http://localhost:8080/mavenproject1/Home_page)")