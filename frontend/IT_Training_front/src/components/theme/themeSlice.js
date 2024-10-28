import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from 'axios'
import { BASE_URL } from "../../utils/constant";

export const fetchAllTheme = createAsyncThunk("theme/fetchAllTheme", async () => {
    const response = await axios.get(`${BASE_URL}themes`);
    const data = await response.data;

    return data;
});

const themeSlice = createSlice({
    name:"theme",
    initialState: {
        themes: []
    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(fetchAllTheme.fulfilled, (state, actions) => {
            state.themes = actions.payload;
            console.log(actions.payload);
            
        })
    }
})

export default themeSlice;