import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { BASE_URL } from "../../utils/constant";

export const fetchTrainingById = createAsyncThunk("training/fetchTrainingById", async (idTraining) => {
    const response = await axios.get(`${BASE_URL}visitor/training/${idTraining}`);
    const data = await response.data;

    return data;
});

export const addTraining = createAsyncThunk("training/addTraining", async(training) => {
    const response = await axios.post(`${BASE_URL}admin/training/add`,training);
    return response.data;
})

export const fetchSessionsByTrainingId = createAsyncThunk("training/fetchSessionsByTrainingId", async (idTraining) => {
    const response = await axios.get(`${BASE_URL}visitor/session/findByTraining/${idTraining}`)
    const data = await response.data;
    return data;
})

const trainingSlice = createSlice({
    name:"training",
    initialState: {
        training: null,
        sessions: [],
        statusAddTraining: null
    },
    reducers: {
        changeStatusAddTraining: (state, actions) => {
            state.statusAddTraining = actions.payload;             
        }
    },
    extraReducers: (builder) => {
        builder.addCase(fetchTrainingById.fulfilled, (state, actions) => {
            state.training = actions.payload;
            console.log(actions.payload);           
        });
        builder.addCase((addTraining.fulfilled), (state, actions) => {
            state.training = actions.payload;
            state.statusAddTraining = true;            
        })

        builder.addCase(fetchSessionsByTrainingId.fulfilled, (state, actions) => {
            state.sessions = actions.payload;
            console.log(actions.payload);
            
        });

    }
})
export const { changeStatusAddTraining } = trainingSlice.actions;
export default trainingSlice.reducer;