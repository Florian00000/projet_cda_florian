import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { BASE_URL } from "../../utils/constant";

export const fetchTestUserById = createAsyncThunk("testUser/fetchTestUserById", async (idTestUser) => {
    const response = await axios.get(`${BASE_URL}visitor/test-user/${idTestUser}`)
    const data = await response.data;
    return data;
})

export const fetchQuestionById = createAsyncThunk("testUser/fetchQuestionById", async (idQuestion) => {
    const response = await axios.get(`${BASE_URL}visitor/test-user/question/${idQuestion}`)
    const data = await response.data;
    return data; 
})

export const fetchUserHasNote = createAsyncThunk("testUser/fetchUserHasNote" , async (credentials) => {
    const response = await axios.get(`${BASE_URL}user/note/${credentials.idTestUser}/userHasNote/${credentials.idUser}`,
        {headers: {
            "Authorization": `Bearer ${credentials.token}`
        }}
    );
    const data = await response.data;
    return data;
})

const testUserSlice = createSlice({
    name:"testUser",
    initialState: {
        testUser: null,
        question : null,
        userHasPassedTest: null
    },
    reducers: {
        emptyUserHasPassedTest: (state, actions) => {
            state.userHasPassedTest = null;
        }
    },
    extraReducers: (builder) => {
        builder.addCase(fetchTestUserById.fulfilled, (state, actions) => {
            state.testUser = actions.payload;
            console.log(actions.payload);            
        });
        builder.addCase(fetchQuestionById.fulfilled, (state, actions) => {
            state.question = actions.payload;
            console.log(actions.payload);            
        });
        builder.addCase(fetchUserHasNote.fulfilled, (state, actions) => {
            console.log(actions.payload);            
            state.userHasPassedTest = actions.payload.data
        })
    }
})

export const { emptyUserHasPassedTest } = testUserSlice.actions;
export default testUserSlice.reducer;