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

export const fetchUserHasNote = createAsyncThunk("testUser/fetchUserHasNote", async (credentials) => {
    const response = await axios.get(`${BASE_URL}user/note/${credentials.idTestUser}/userHasNote/${credentials.idUser}`,
        {
            headers: {
                "Authorization": `Bearer ${credentials.token}`
            }
        }
    );
    const data = await response.data;
    return data;
})

export const fetchAddNote = createAsyncThunk("testUser/fetchAddNote", async ({note, token}, { rejectWithValue }) => {
    try {
        const reponse = await axios.post(`${BASE_URL}user/note/add`, note, {
            headers: {
                "Authorization": `Bearer ${token}`
            }
        });
        const data = await reponse.data;
        return data;
    } catch (error) {
        const serializedError = error.response?.data || { message: error.message };
        return rejectWithValue(serializedError)
    }

})

const testUserSlice = createSlice({
    name: "testUser",
    initialState: {
        testUser: null,
        question: null,
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
            state.userHasPassedTest = actions.payload.data
        });
        builder.addCase(fetchAddNote.fulfilled, (state, action) => {
            console.log(action.payload);
        });
        builder.addCase(fetchAddNote.rejected, (state, actions) => {
            console.log(actions.payload);                   
        })

    }
})

export const { emptyUserHasPassedTest } = testUserSlice.actions;
export default testUserSlice.reducer;