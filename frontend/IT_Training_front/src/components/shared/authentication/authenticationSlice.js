import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { BASE_URL } from "../../../utils/constant";
import axios from "axios"
import { jwtDecode } from "jwt-decode";

export const fetchLogin = createAsyncThunk("authentication/login", 
    async (credentials, {rejectWithValue}) => {
        try {
            const response = await axios.post(`${BASE_URL}auth/login`, credentials);                           
            return response.data;            
        } catch (error) {
            return rejectWithValue(error.response.data)
        }    
})

const authenticationSlice = createSlice({
    name: "authentication",
    initialState: {
        token: localStorage.getItem('token') || null,
        error: null
    },
    reducers: {
        logout: (state, actions) => {
            localStorage.removeItem("token");
            localStorage.removeItem("user");
            state.token = null;
        }
    },
    extraReducers: (builder) => {
        builder.addCase(fetchLogin.fulfilled, (state, actions) => {
            console.log(actions.payload);
            
            state.token = actions.payload.data.token;
            localStorage.setItem('token', actions.payload.data.token);
            localStorage.setItem('user', JSON.stringify(jwtDecode(actions.payload.data.token)))
            state.error = null;          
        });
        builder.addCase(fetchLogin.rejected, (state, actions) => {                        
            console.log(actions.payload || "rejet"); 
            state.error = actions.payload;         
        })
    }
})

export const { logout } = authenticationSlice.actions;
export default authenticationSlice.reducer;