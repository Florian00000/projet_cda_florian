import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { BASE_URL } from "../../utils/constant";

export const fetchTrainingById = createAsyncThunk("training/fetchTrainingById", async (idTraining) => {
    const response = await axios.get(`${BASE_URL}training/${idTraining}`);
    const data = await response.data;

    return data;
});

export const addTraining = createAsyncThunk("training/addTraining", async(training) => {
    const response = await axios.post(`${BASE_URL}admin/training/add`,training);
    const status =  response.status;
    return status;
})

export const fetchSessionsByTrainingId = createAsyncThunk("training/fetchSessionsByTrainingId", async (idTraining) => {
    const response = await axios.get(`${BASE_URL}session/findByTraining/${idTraining}`)
    const data = await response.data;
    return data;
})

const trainingSlice = createSlice({
    name:"training",
    initialState: {
        training: null,
        sessions: []
    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(fetchTrainingById.fulfilled, (state, actions) => {
            state.training = actions.payload;
            console.log(actions.payload);           
        });
        builder.addCase((addTraining.fulfilled), (state, actions) => {
            console.log(actions.payload);            
        } )

        builder.addCase(fetchSessionsByTrainingId.fulfilled, (state, actions) => {
            state.sessions = actions.payload;
            console.log(actions.payload);
            
        });

    }
})

export default trainingSlice.reducer;