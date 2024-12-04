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

export const fetchAllSubThemes = createAsyncThunk("theme/fetchAllSubThemes", async () => {
    const response = await axios.get(`${BASE_URL}subThemes`);
    const data = await response.data;

    return data;
} )

export const fetchAllTrainingBySubThemeId = createAsyncThunk("theme/fetchAllTrainingBySubThemeId", async (idSubTheme) => {
    const response = await axios.get(`${BASE_URL}training/findBySubTheme/${idSubTheme}`)
    const data = await response.data;

    return data;
} )

export const fetchAllTrainings = createAsyncThunk("theme/fetchAllTrainings", async () => {
    const response = await axios.get(`${BASE_URL}training`)
    const data = await response.data;
    return data;
})

const themeSlice = createSlice({
    name:"theme",
    initialState: {
        list: [],
        searchQuery: ""
    },
    reducers: {
        searchTraining: (state, action) => {                                  
            state.searchQuery = action.payload;           
        }
    },
    extraReducers: (builder) => {
        builder.addCase(fetchAllTheme.fulfilled, (state, actions) => {
            state.list = actions.payload;
            console.log(actions.payload);            
        });
        builder.addCase(fetchAllSubThemeByThemeId.fulfilled, (state, actions) => {
            state.list = actions.payload;
            console.log(actions.payload);            
        });
        builder.addCase(fetchAllSubThemes.fulfilled, (state, action) => {
            state.list = action.payload;
            console.log(action.payload);            
        });
        builder.addCase(fetchAllTrainingBySubThemeId.fulfilled, (state, actions) => {
            state.list = actions.payload;
            console.log(actions.payload);            
        });
        builder.addCase(fetchAllTrainings.fulfilled, (state, actions) => {
            state.list = actions.payload;
            console.log(actions.payload);
            
        })
    }
})
export const {searchTraining} = themeSlice.actions;
export default themeSlice.reducer;