import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { BASE_URL } from "../../utils/constant";

export const fetchTrainingById = createAsyncThunk("training/fetchTrainingById", async (idTraining) => {
    const response = await axios.get(`${BASE_URL}training/${idTraining}`);
    const data = await response.data;

    return data;
});

const trainingSlice = createSlice({
    name:"training",
    initialState: {
        training: null
    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(fetchTrainingById.fulfilled, (state, actions) => {
            state.training = actions.payload;
            console.log(actions.payload);           
        });
    }
})

export default trainingSlice.reducer;