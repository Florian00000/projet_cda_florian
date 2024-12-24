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

export const fetchRegister = createAsyncThunk("authentication/regioster", 
    async (credentials, {rejectWithValue}) => {
        try {
            const response = await axios.post(`${BASE_URL}auth/register`, credentials);
            return response.data;
        } catch (error) {
            return rejectWithValue(error.response.data)
        }
    }
)

const authenticationSlice = createSlice({
    name: "authentication",
    initialState: {
        token: localStorage.getItem('token') || null,
        user: JSON.parse(localStorage.getItem('user')) || null,
        error: null,
        alert: false,
        searchAlert: false        
    },
    reducers: {
        logout: (state, actions) => {
            localStorage.removeItem("token");
            localStorage.removeItem("user");
            state.token = null;
            state.user = null;
            state.alert = false;           
        },
        emptyError: (state, actions) => {
            state.error = null;
        },
        triggerAlert: (state, actions) => {
            state.alert = true
        },
        emptyAlert: (state, actions) => {
            state.alert = false;
        },
        searchAlert: (state, actions) => {
            state.searchAlert = !state.searchAlert;
        }
    },
    extraReducers: (builder) => {
        builder.addCase(fetchLogin.fulfilled, (state, actions) => {
            console.log(actions.payload);
            
            state.token = actions.payload.data.token;
            localStorage.setItem('token', actions.payload.data.token);
            localStorage.setItem('user', JSON.stringify(jwtDecode(actions.payload.data.token)))
            state.user = jwtDecode(actions.payload.data.token);            
            state.error = null;          
        });
        builder.addCase(fetchLogin.rejected, (state, actions) => {                        
            console.log(actions.payload || "rejet"); 
            state.error = actions.payload || "rejet";         
        });
        builder.addCase(fetchRegister.fulfilled, (state, actions) => {
            console.log(actions.payload);            
            state.token = actions.payload.data.token;
            localStorage.setItem('token', actions.payload.data.token);
            localStorage.setItem('user', JSON.stringify(jwtDecode(actions.payload.data.token)))
            state.user = jwtDecode(actions.payload.data.token);            
            state.error = null;
        });
        builder.addCase(fetchRegister.rejected, (state, actions) => {
            console.log(actions.payload || "rejet"); 
            state.error = actions.payload || "rejet"; 
        })
    }
})

export const { logout, emptyError, triggerAlert, emptyAlert, searchAlert } = authenticationSlice.actions;
export default authenticationSlice.reducer;