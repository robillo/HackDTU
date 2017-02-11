package com.appbusters.robinkamboj.hackdtu.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.appbusters.robinkamboj.hackdtu.R;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

import java.util.concurrent.TimeUnit;

public class FitRec extends AppCompatActivity {

    private static final int REQUEST_OAUTH = 1;
    private static final String AUTH_PENDING = "auth_state_pending";
    private boolean authInProgress = false;
    private GoogleApiClient mApiClient;
    private OnDataPointListener mListener;
    public static final String CLIENT_ID = "900249697593-uebcp9lvp3c5jqpjc8p1atna4o1kcmoi.apps.googleusercontent.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_rec);


        if (savedInstanceState != null) {
            authInProgress = savedInstanceState.getBoolean(AUTH_PENDING);
        }

//        mApiClient = new GoogleApiClient.Builder(this)
//                .addApi(Fitness.SENSORS_API)
//                .addScope(new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE))
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .build();
        mApiClient = new GoogleApiClient.Builder(this).addApi(Fitness.SENSORS_API)
                .addScope(new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE))
                .build();

        //subscribe();

        findFitnessDataSources();

    }
//    public void subscribe() {
//        // To create a subscription, invoke the Recording API. As soon as the subscription is
//        // active, fitness data will start recording.
//        Fitness.SensorsApi.subscribe(mApiClient, DataType.TYPE_STEP_COUNT_CUMULATIVE)
//                .setResultCallback(new ResultCallback<Status>() {
//                    public static final String TAG = "fit...";
//
//                    @Override
//                    public void onResult(Status status) {
//                        if (status.isSuccess()) {
//                            if (status.getStatusCode()
//                                    == FitnessStatusCodes.SUCCESS_ALREADY_SUBSCRIBED) {
//                                Log.i(TAG, "Existing subscription for activity detected.");
//                            } else {
//                                Log.i(TAG, "Successfully subscribed!");
//                            }
//                        } else {
//                            Log.w(TAG, "There was a problem subscribing.");
//                        }
//                    }
//                });
//    }
    @Override
    protected void onStart() {
        super.onStart();
        mApiClient.connect();
    }
//    @Override
//    public void onConnected(Bundle bundle) {
//        DataSourcesRequest dataSourceRequest = new DataSourcesRequest.Builder()
//                .setDataTypes( DataType.TYPE_STEP_COUNT_CUMULATIVE )
//                .setDataSourceTypes( DataSource.TYPE_RAW )
//                .build();
//
//        ResultCallback<DataSourcesResult> dataSourcesResultCallback = new ResultCallback<DataSourcesResult>() {
//            @Override
//            public void onResult(DataSourcesResult dataSourcesResult) {
//                for( DataSource dataSource : dataSourcesResult.getDataSources() ) {
//                    if( DataType.TYPE_STEP_COUNT_CUMULATIVE.equals( dataSource.getDataType() ) ) {
//                        registerFitnessDataListener(dataSource, DataType.TYPE_STEP_COUNT_CUMULATIVE);
//                    }
//                }
//            }
//        };
//
//        Fitness.SensorsApi.findDataSources(mApiClient, dataSourceRequest)
//                .setResultCallback(dataSourcesResultCallback);
//    }
//    private void registerFitnessDataListener(DataSource dataSource, DataType dataType) {
//
//        SensorRequest request = new SensorRequest.Builder()
//                .setDataSource( dataSource )
//                .setDataType( dataType )
//                .setSamplingRate( 3, TimeUnit.SECONDS )
//                .build();
//
//        Fitness.SensorsApi.add( mApiClient, request, this )
//                .setResultCallback(new ResultCallback<Status>() {
//                    @Override
//                    public void onResult(Status status) {
//                        if (status.isSuccess()) {
//                            Log.e( "GoogleFit", "SensorApi successfully added" );
//                        }
//                    }
//                });
//    }

//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if( requestCode == REQUEST_OAUTH ) {
//            authInProgress = false;
//            if( resultCode == RESULT_OK ) {
//                if( !mApiClient.isConnecting() && !mApiClient.isConnected() ) {
//                    mApiClient.connect();
//                }
//            } else if( resultCode == RESULT_CANCELED ) {
//                Log.e( "GoogleFit", "RESULT_CANCELED" );
//            }
//        } else {
//            Log.e("GoogleFit", "requestCode NOT request_oauth"+resultCode);
//        }
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//        if( !authInProgress ) {
//            try {
//                authInProgress = true;
//                connectionResult.startResolutionForResult( this, REQUEST_OAUTH );
//            } catch(IntentSender.SendIntentException e ) {
//
//            }
//        } else {
//            Log.e( "GoogleFit", "auth error" );
//        }
//    }
//
//    @Override
//    public void onDataPoint(DataPoint dataPoint) {
//        for( final Field field : dataPoint.getDataType().getFields() ) {
//            final Value value = dataPoint.getValue( field );
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(getApplicationContext(), "Field: " + field.getName() + " Value: " + value, Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    }

    private void findFitnessDataSources() {
        // [START find_data_sources]
        // Note: Fitness.SensorsApi.findDataSources() requires the ACCESS_FINE_LOCATION permission.
        Fitness.SensorsApi.findDataSources(mApiClient, new DataSourcesRequest.Builder()
                // At least one datatype must be specified.
                .setDataTypes(DataType.TYPE_LOCATION_SAMPLE)
                // Can specify whether data type is raw or derived.
                .setDataSourceTypes(DataSource.TYPE_RAW)
                .build())
                .setResultCallback(new ResultCallback<DataSourcesResult>() {
                    public static final String TAG = "fkfkfydfkdlu";

                    @Override
                    public void onResult(DataSourcesResult dataSourcesResult) {
                        Log.i(TAG, "Result: " + dataSourcesResult.getStatus().toString());
                        for (DataSource dataSource : dataSourcesResult.getDataSources()) {
                            Log.i(TAG, "Data source found: " + dataSource.toString());
                            Log.i(TAG, "Data Source type: " + dataSource.getDataType().getName());

                            //Let's register a listener to receive Activity data!
                            if (dataSource.getDataType().equals(DataType.TYPE_LOCATION_SAMPLE)
                                    && mListener == null) {
                                Log.i(TAG, "Data source for LOCATION_SAMPLE found!  Registering.");
                                registerFitnessDataListener(dataSource,
                                        DataType.TYPE_LOCATION_SAMPLE);
                            }
                        }
                    }
                });
        // [END find_data_sources]
    }

    /**
     * Register a listener with the Sensors API for the provided {@link DataSource} and
     * {@link DataType} combo.
     */
    private void registerFitnessDataListener(DataSource dataSource, DataType dataType) {
        // [START register_data_listener]
        mListener = new OnDataPointListener() {
            public static final String TAG = "NONONONNO";

            @Override
            public void onDataPoint(DataPoint dataPoint) {
                for (Field field : dataPoint.getDataType().getFields()) {
                    Value val = dataPoint.getValue(field);
                    Log.i(TAG, "Detected DataPoint field: " + field.getName());
                    Log.i(TAG, "Detected DataPoint value: " + val);
                }
            }
        };

        Fitness.SensorsApi.add(
                mApiClient,
                new SensorRequest.Builder()
                        .setDataSource(dataSource) // Optional but recommended for custom data sets.
                        .setDataType(dataType) // Can't be omitted.
                        .setSamplingRate(10, TimeUnit.SECONDS)
                        .build(),
                mListener)
                .setResultCallback(new ResultCallback<Status>() {
                    public static final String TAG = "YOOYOYYO";

                    @Override
                    public void onResult(Status status) {
                        if (status.isSuccess()) {
                            Log.i(TAG, "Listener registered!");
                        } else {
                            Log.i(TAG, "Listener not registered.");
                        }
                    }
                });
        // [END register_data_listener]
    }
}
