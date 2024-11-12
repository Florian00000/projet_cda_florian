import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { BASE_URL } from "../../utils/constant";

export const fetchTestUserById = createAsyncThunk("testUser/fetchTestUserById", async (idTestUser) => {
    const response = await axios.get(`${BASE_URL}test-user/${idTestUser}`)
    const data = await response.data;
    return data;
})

const testUserSlice = createSlice({
    name:"testUser",
    initialState: {
        testUser: null
    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(fetchTestUserById.fulfilled, (state, actions) => {
            state.testUser = actions.payload;
            console.log(actions.payload);            
        })
    }
})

export default testUserSlice.reducer;