import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { BASE_URL } from "../../utils/constant";
import axios from "axios";

export const fetchAddEvaluation = createAsyncThunk("evaluation/fetchAddEvaluation", 
    async({evaluation, token}, {rejectWithValue}) => {
        try {
            const response = await axios.post(`${BASE_URL}user/evaluation/add`,
                evaluation,
                {headers: {
                    "Authorization": `Bearer ${token}`
                }}
            )
            return response.data;
        } catch (error) {
            const serializedError = error.response?.data || { message: error.message };
            return rejectWithValue(serializedError);
        }
    }
)

export const fetchAllEvaluationsReadByAdmin = createAsyncThunk("evaluation/fetchAllEvaluationsReadByAdmin",
    async(token, {rejectWithValue}) => {
        try {
            const response = await axios.get(`${BASE_URL}admin/evaluation/readByAdmin=true`, 
                {headers: {
                    "Authorization": `Bearer ${token}`
                }}
            )
            return response.data;
        } catch (error) {
            const serializedError = error.response?.data || { message: error.message };
            return rejectWithValue(serializedError);
        }
    }
)

export const fetchAllEvaluationsNotReadByAdmin = createAsyncThunk("evaluation/fetchAllEvaluationsNotReadByAdmin",
    async(token, {rejectWithValue}) => {
        try {
            const response = await axios.get(`${BASE_URL}admin/evaluation/readByAdmin=false`, 
                {headers: {
                    "Authorization": `Bearer ${token}`
                }}
            )
            return response.data;
        } catch (error) {
            const serializedError = error.response?.data || { message: error.message };
            return rejectWithValue(serializedError);
        }
    }
)


const evaluationSlice = createSlice({
    name:"evaluation",
    initialState: {
        evaluationReturn: null,
        evluationsRead: [],
        evluationsNotRead: []
    },
    reducers: {
        emptyEvaluationReturn: (state, actions) => {
            state.evaluationReturn = null;
        }
    },
    extraReducers: (builder) => {
        builder.addCase(fetchAddEvaluation.fulfilled, (state, actions) => {
            state.evaluationReturn = actions.payload;
            console.log(state.evaluationReturn);            
        });
        builder.addCase(fetchAddEvaluation.rejected, (state, actions) => {
            state.evaluationReturn = actions.payload;
            console.log(state.evaluationReturn);           
        });
        builder.addCase(fetchAllEvaluationsReadByAdmin.fulfilled, (state, actions) => {
            state.evluationsRead = actions.payload;
            console.log(state.evluationsRead);
        });
        builder.addCase(fetchAllEvaluationsNotReadByAdmin.fulfilled, (state, actions) => {
            state.evluationsNotRead = actions.payload;
            console.log(state.evluationsNotRead);
        });
    }
})
export const { emptyEvaluationReturn } = evaluationSlice.actions;
export default evaluationSlice.reducer;