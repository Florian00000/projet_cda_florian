import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from 'axios'
import { BASE_URL } from "../../utils/constant";

export const fetchAllTheme = createAsyncThunk("theme/fetchAllTheme", async () => {
    const response = await axios.get(`${BASE_URL}themes`);
    const data = await response.data;

    return data;
});

export const fetchAllSubThemeByThemeId = createAsyncThunk("theme/fetchAllSubThemeByThemeId", async (idTheme) => {
    const response = await axios.get(`${BASE_URL}subThemes/findByTheme/${idTheme}`);
    const data = await response.data;

    return data;
});

export const fetchAllTrainingBySubThemeId = createAsyncThunk("theme/fetchAllTrainingBySubThemeId", async (idSubTheme) => {
    const response = await axios.get(`${BASE_URL}training/findBySubTheme/${idSubTheme}`)
    const data = await response.data;

    return data;
} )

const themeSlice = createSlice({
    name:"theme",
    initialState: {
        list: []
    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(fetchAllTheme.fulfilled, (state, actions) => {
            state.list = actions.payload;
            console.log(actions.payload);            
        });
        builder.addCase(fetchAllSubThemeByThemeId.fulfilled, (state, actions) => {
            state.list = actions.payload;
            console.log(actions.payload);            
        });
        builder.addCase(fetchAllTrainingBySubThemeId.fulfilled, (state, actions) => {
            state.list = actions.payload;
            console.log(actions.payload);
            
        })
    }
})

export default themeSlice.reducer;