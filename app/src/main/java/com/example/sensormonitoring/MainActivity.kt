// This code is a modification of the example code given in Android studio documentation
package com.example.sensormonitoring

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView


class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager

    // Sensor variables that must be initialized
    private var accelerometer: Sensor? = null
    private var magneticField: Sensor? = null
    private var gravity: Sensor? = null
    private var gyroscope: Sensor? = null
    private var light: Sensor? = null
    private var proximity: Sensor? = null
    private var linearAcc: Sensor? = null
    private var rotationalAcc: Sensor? = null
    private var gameRotational: Sensor? = null
    private var significantMotion: Sensor? = null
    private var stepDetect: Sensor? = null
    private var stepCounter: Sensor? = null
    private var hingeAngle: Sensor? = null
    private var humidity: Sensor? = null
    private var pressure: Sensor? = null
    private var temperature: Sensor? = null
    private var pose: Sensor? = null

    private lateinit var tableLayout: TableLayout

    // Declaring Table View variables
    private lateinit var tableRow1: TableRow
    private lateinit var tableRow2: TableRow
    private lateinit var tableRow3: TableRow
    private lateinit var tableRow4: TableRow
    private lateinit var tableRow5: TableRow
    private lateinit var tableRow6: TableRow
    private lateinit var tableRow7: TableRow
    private lateinit var tableRow8: TableRow
    private lateinit var tableRow9: TableRow
    private lateinit var tableRow10: TableRow
    private lateinit var tableRow11: TableRow
    private lateinit var tableRow12: TableRow
    private lateinit var tableRow13: TableRow
    private lateinit var tableRow14: TableRow
    private lateinit var tableRow15: TableRow
    private lateinit var tableRow16: TableRow
    private lateinit var tableRow17: TableRow

    // Declaring the textbox variables -- For detecting presence
    private lateinit var accPresence: TextView
    private lateinit var mfPresence: TextView
    private lateinit var gPresence: TextView
    private lateinit var gyroPresence: TextView
    private lateinit var lightPresence: TextView
    private lateinit var proxPresence: TextView
    private lateinit var laPresence: TextView
    private lateinit var raPresence: TextView
    private lateinit var grPresence: TextView
    private lateinit var smPresence: TextView
    private lateinit var sdPresence: TextView
    private lateinit var scPresence: TextView
    private lateinit var hingePresence: TextView
    private lateinit var humPresence: TextView
    private lateinit var pressurePresence: TextView
    private lateinit var tempPresence: TextView
    private lateinit var posePresence: TextView

    // Declaring textbox variables -- For detecting accuracy
    private lateinit var accAcc: TextView
    private lateinit var mfAcc: TextView
    private lateinit var gAcc: TextView
    private lateinit var gyroAcc: TextView
    private lateinit var lightAcc: TextView
    private lateinit var proxAcc: TextView
    private lateinit var laAcc: TextView
    private lateinit var raAcc: TextView
    private lateinit var grAcc: TextView
    private lateinit var smAcc: TextView
    private lateinit var sdAcc: TextView
    private lateinit var scAcc: TextView
    private lateinit var hingeAcc: TextView
    private lateinit var humAcc: TextView
    private lateinit var pressureAcc: TextView
    private lateinit var tempAcc: TextView
    private lateinit var poseAcc: TextView

    // Declaring textbox variables -- For detecting Value
    private lateinit var accValue: TextView
    private lateinit var mfValue: TextView
    private lateinit var gValue: TextView
    private lateinit var gyroValue: TextView
    private lateinit var lightValue: TextView
    private lateinit var proxValue: TextView
    private lateinit var laValue: TextView
    private lateinit var raValue: TextView
    private lateinit var grValue: TextView
    private lateinit var smValue: TextView
    private lateinit var sdValue: TextView
    private lateinit var scValue: TextView
    private lateinit var hingeValue: TextView
    private lateinit var humValue: TextView
    private lateinit var pressureValue: TextView
    private lateinit var tempValue: TextView
    private lateinit var poseValue: TextView

    fun initializeSensors(){
        // To initialize listener for pressure, temperature and light sensors
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        magneticField = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
        gravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED)
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        linearAcc = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)
        rotationalAcc = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
        gameRotational = sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR)
        significantMotion = sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION)
        stepDetect= sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
        stepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        hingeAngle = sensorManager.getDefaultSensor(Sensor.TYPE_HINGE_ANGLE)
        humidity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY)
        pressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)
        temperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        pose = sensorManager.getDefaultSensor(Sensor.TYPE_POSE_6DOF)
    }

    // Initializing the text box for noting the presence
    fun initializePresenceText(){
        accPresence = tableRow1.getChildAt(1) as  TextView
        mfPresence = tableRow2.getChildAt(1) as  TextView
        gPresence = tableRow3.getChildAt(1) as  TextView
        gyroPresence = tableRow4.getChildAt(1) as  TextView
        lightPresence = tableRow5.getChildAt(1) as  TextView
        proxPresence = tableRow6.getChildAt(1) as  TextView
        laPresence = tableRow7.getChildAt(1) as  TextView
        raPresence = tableRow8.getChildAt(1) as  TextView
        grPresence = tableRow9.getChildAt(1) as  TextView
        smPresence = tableRow10.getChildAt(1) as  TextView
        sdPresence = tableRow11.getChildAt(1) as  TextView
        scPresence = tableRow12.getChildAt(1) as  TextView
        hingePresence = tableRow13.getChildAt(1) as  TextView
        humPresence = tableRow14.getChildAt(1) as  TextView
        pressurePresence = tableRow15.getChildAt(1) as  TextView
        tempPresence = tableRow16.getChildAt(1) as  TextView
        posePresence = tableRow17.getChildAt(1) as  TextView
    }

    // Initializing the text box for noting the Accuracy
    fun initializeAccuracyText(){
        accAcc = tableRow1.getChildAt(2) as  TextView
        mfAcc = tableRow2.getChildAt(2) as  TextView
        gAcc = tableRow3.getChildAt(2) as  TextView
        gyroAcc = tableRow4.getChildAt(2) as  TextView
        lightAcc = tableRow5.getChildAt(2) as  TextView
        proxAcc = tableRow6.getChildAt(2) as  TextView
        laAcc = tableRow7.getChildAt(2) as  TextView
        raAcc = tableRow8.getChildAt(2) as  TextView
        grAcc = tableRow9.getChildAt(2) as  TextView
        smAcc = tableRow10.getChildAt(2) as  TextView
        sdAcc = tableRow11.getChildAt(2) as  TextView
        scAcc = tableRow12.getChildAt(2) as  TextView
        hingeAcc = tableRow13.getChildAt(2) as  TextView
        humAcc = tableRow14.getChildAt(2) as  TextView
        pressureAcc = tableRow15.getChildAt(2) as  TextView
        tempAcc = tableRow16.getChildAt(2) as  TextView
        poseAcc = tableRow17.getChildAt(2) as  TextView
    }


    // Initializing the text box for noting the Values
    fun initializeValueText(){
        accValue = tableRow1.getChildAt(3) as  TextView
        mfValue =tableRow2.getChildAt(3) as  TextView
        gValue = tableRow3.getChildAt(3) as  TextView
        gyroValue = tableRow4.getChildAt(3) as  TextView
        lightValue = tableRow5.getChildAt(3) as  TextView
        proxValue = tableRow6.getChildAt(3) as  TextView
        laValue = tableRow7.getChildAt(3) as  TextView
        raValue = tableRow8.getChildAt(3) as  TextView
        grValue = tableRow9.getChildAt(3) as  TextView
        smValue = tableRow10.getChildAt(3) as  TextView
        sdValue = tableRow11.getChildAt(3) as  TextView
        scValue = tableRow12.getChildAt(3) as  TextView
        hingeValue = tableRow13.getChildAt(3) as  TextView
        humValue = tableRow14.getChildAt(3) as  TextView
        pressureValue = tableRow15.getChildAt(3) as  TextView
        tempValue = tableRow16.getChildAt(3) as  TextView
        poseValue = tableRow17.getChildAt(3) as  TextView
    }

    fun initializeTableView(){
        tableRow1 = tableLayout.findViewById(R.id.tableRow1)
        tableRow2 = tableLayout.findViewById(R.id.tableRow2)
        tableRow3 = tableLayout.findViewById(R.id.tableRow3)
        tableRow4 = tableLayout.findViewById(R.id.tableRow4)
        tableRow5 = tableLayout.findViewById(R.id.tableRow5)
        tableRow6 = tableLayout.findViewById(R.id.tableRow6)
        tableRow7 = tableLayout.findViewById(R.id.tableRow7)
        tableRow8 = tableLayout.findViewById(R.id.tableRow8)
        tableRow9 = tableLayout.findViewById(R.id.tableRow9)
        tableRow10 = tableLayout.findViewById(R.id.tableRow10)
        tableRow11 = tableLayout.findViewById(R.id.tableRow11)
        tableRow12 = tableLayout.findViewById(R.id.tableRow12)
        tableRow13 = tableLayout.findViewById(R.id.tableRow13)
        tableRow14 = tableLayout.findViewById(R.id.tableRow14)
        tableRow15 = tableLayout.findViewById(R.id.tableRow15)
        tableRow16 = tableLayout.findViewById(R.id.tableRow16)
        tableRow17 = tableLayout.findViewById(R.id.tableRow17)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        initializeSensors()
        tableLayout = findViewById(R.id.tableLayout)
        initializeTableView()
        initializePresenceText()
        initializeAccuracyText()
        initializeValueText()
        checkSensorPresence()
    }

    fun checkSensorPresence(){
        accPresence.text = if (accelerometer != null) "Y" else "N"
        mfPresence.text = if (magneticField != null) "Y" else "N"
        gPresence.text = if (gravity!= null) "Y" else "N"
        gyroPresence.text = if (gyroscope != null) "Y" else "N"
        lightPresence.text = if (light != null) "Y" else "N"
        proxPresence.text = if (proximity != null) "Y" else "N"
        laPresence.text = if (linearAcc != null) "Y" else "N"
        raPresence.text = if (rotationalAcc != null) "Y" else "N"
        smPresence.text = if (significantMotion != null) "Y" else "N"
        sdPresence.text = if (stepDetect != null) "Y" else "N"
        scPresence.text = if (stepCounter != null) "Y" else "N"
        hingePresence.text = if (hingeAngle != null) "Y" else "N"
        humPresence.text = if (humidity != null) "Y" else "N"
        pressurePresence.text = if (pressure != null) "Y" else "N"
        tempPresence.text = if (temperature != null) "Y" else "N"
        posePresence.text = if (pose != null) "Y" else "N"

    }


    //TODO: Must write a function that checks the presence of a sensor or not
    //TODO: Game rotational vector and rotational vectors are vectors -- must put in a list and then
    // convert to a string
    // TODO: Magnetic field and gyroscope are uncaliberated -- what does this mean (might change for pixel phones)

    // This function is called when the sensor values change
    override fun onSensorChanged(event: SensorEvent?) {
        when(event!!.sensor.type){
            Sensor.TYPE_ACCELEROMETER -> accValue.text = event.values[0].toString()
            Sensor.TYPE_MAGNETIC_FIELD -> mfValue.text = event.values[0].toString()
            Sensor.TYPE_GRAVITY -> gValue.text = event.values[0].toString()
            Sensor.TYPE_GYROSCOPE_UNCALIBRATED -> gyroValue.text = event.values[0].toString()
            Sensor.TYPE_LIGHT-> lightValue.text = event.values[0].toString()
            Sensor.TYPE_PROXIMITY-> proxValue.text = event.values[0].toString()
            Sensor.TYPE_LINEAR_ACCELERATION-> laValue.text = event.values[0].toString()
            Sensor.TYPE_ROTATION_VECTOR-> raValue.text = event.values[0].toString()
            Sensor.TYPE_GAME_ROTATION_VECTOR-> grValue.text = event.values[0].toString()
            Sensor.TYPE_SIGNIFICANT_MOTION-> smValue.text = event.values[0].toString()
            Sensor.TYPE_STEP_DETECTOR-> sdValue.text = event.values[0].toString()
            Sensor.TYPE_STEP_COUNTER-> scValue.text = event.values[0].toString()
            Sensor.TYPE_HINGE_ANGLE-> hingeValue.text = event.values[0].toString()
            Sensor.TYPE_RELATIVE_HUMIDITY-> humValue.text = event.values[0].toString()
            Sensor.TYPE_PRESSURE-> pressureValue.text = event.values[0].toString()
            Sensor.TYPE_AMBIENT_TEMPERATURE-> tempValue.text= event.values[0].toString()
            Sensor.TYPE_POSE_6DOF-> poseValue.text = event.values[0].toString()
        }
    }

    // This function is called when the accuracy changes
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        if (sensor != null) {
            when(sensor.type) {
                Sensor.TYPE_ACCELEROMETER -> accAcc.text = accuracy.toString()
                Sensor.TYPE_MAGNETIC_FIELD -> mfAcc.text = accuracy.toString()
                Sensor.TYPE_GRAVITY -> gAcc.text = accuracy.toString()
                Sensor.TYPE_GYROSCOPE_UNCALIBRATED -> gyroAcc.text = accuracy.toString()
                Sensor.TYPE_LIGHT-> lightAcc.text = accuracy.toString()
                Sensor.TYPE_PROXIMITY-> proxAcc.text = accuracy.toString()
                Sensor.TYPE_LINEAR_ACCELERATION-> laAcc.text = accuracy.toString()
                Sensor.TYPE_ROTATION_VECTOR-> raAcc.text = accuracy.toString()
                Sensor.TYPE_GAME_ROTATION_VECTOR-> grAcc.text = accuracy.toString()
                Sensor.TYPE_SIGNIFICANT_MOTION-> smAcc.text = accuracy.toString()
                Sensor.TYPE_STEP_DETECTOR-> sdAcc.text = accuracy.toString()
                Sensor.TYPE_STEP_COUNTER-> scAcc.text = accuracy.toString()
                Sensor.TYPE_HINGE_ANGLE-> hingeAcc.text = accuracy.toString()
                Sensor.TYPE_RELATIVE_HUMIDITY-> humAcc.text = accuracy.toString()
                Sensor.TYPE_PRESSURE-> pressureAcc.text = accuracy.toString()
                Sensor.TYPE_AMBIENT_TEMPERATURE-> tempAcc.text= accuracy.toString()
                Sensor.TYPE_POSE_6DOF-> poseAcc.text = accuracy.toString()

            }
        }
    }

    // Register a listener for the sensor
    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, magneticField, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, gravity, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, linearAcc, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, rotationalAcc, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, gameRotational, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, significantMotion, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, stepDetect, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, stepCounter, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, hingeAngle, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, humidity , SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, pressure, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, temperature , SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, pose , SensorManager.SENSOR_DELAY_NORMAL)

    }

    // Unregister the listener for the sensors
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }


}