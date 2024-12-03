import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { BASE_URL } from "../../utils/constant";

export const fetchTrainingById = createAsyncThunk("training/fetchTrainingById", async (idTraining) => {
    const response = await axios.get(`${BASE_URL}visitor/training/${idTraining}`);
    const data = await response.data;

    return data;
});

export const addTraining = createAsyncThunk("training/addTraining", async(credentials) => {
    const response = await axios.post(`${BASE_URL}admin/training/add`,
        credentials.training,
        {headers: {
            "Authorization": `Bearer ${credentials.token}`
        }}
    );
    return response.data;
})

export const fetchSessionsByTrainingId = createAsyncThunk("training/fetchSessionsByTrainingId", async (idTraining) => {
    const response = await axios.get(`${BASE_URL}visitor/session/findByTraining/${idTraining}`)
    const data = await response.data;
    return data;
})

export const fetchAddUserToSession = createAsyncThunk("training/fetchAddUserToSession", async ({user, token, session} ,{ rejectWithValue }) => {
    try {
        const response = await axios.patch(`${BASE_URL}user/register/${user.userId}/session/${session.id}`, 
            {},
            {headers: {
                "Authorization": `Bearer ${token}`
            }}
        )
        const data = await response.data;
        return data;
    } catch (error) {
        const serializedError = error.response?.data || { message: error.message };
        return rejectWithValue(serializedError)
    }
    
});

export const fetchUserHasRegisteredToSession = createAsyncThunk("training/fetchUserHasRegisteredToSession",
     async({user, token, session}, { rejectWithValue }) => {
        try {
            const response = await axios.get(`${BASE_URL}user/registered/${user.userId}/session/${session.id}`, 
                {headers: {
                    "Authorization": `Bearer ${token}`
                }}
            )
            const data = response.data;
            return data;
        } catch (error) {
            const serializedError = error.response?.data || { message: error.message };
            return rejectWithValue(serializedError);
        }
})

const trainingSlice = createSlice({
    name:"training",
    initialState: {
        training: null,
        sessions: [],
        statusAddTraining: null,
        userHasRegistered: null
    },
    reducers: {
        changeStatusAddTraining: (state, actions) => {
            state.statusAddTraining = actions.payload;             
        }
    },
    extraReducers: (builder) => {
        builder.addCase(fetchTrainingById.fulfilled, (state, actions) => {
            state.training = actions.payload;
            console.log(actions.payload);           
        });
        builder.addCase((addTraining.fulfilled), (state, actions) => {
            state.training = actions.payload;
            state.statusAddTraining = true;            
        })

        builder.addCase(fetchSessionsByTrainingId.fulfilled, (state, actions) => {
            state.sessions = actions.payload;
            console.log(actions.payload);            
        });
        builder.addCase(fetchAddUserToSession.fulfilled, (state, actions) => {
            state.userHasRegistered = actions.payload.data
            console.log(actions.payload);            
        });
        builder.addCase(fetchAddUserToSession.rejected, (state, actions) => {
            state.userHasRegistered = actions.payload.data
            console.log(actions.payload);            
        });
        builder.addCase(fetchUserHasRegisteredToSession.fulfilled, (state, actions) => {
            state.userHasRegistered = actions.payload.data;
            console.log(actions.payload);
        })
        builder.addCase(fetchUserHasRegisteredToSession.rejected, (state, actions) => {
            state.userHasRegistered = actions.payload.data;
            console.log(actions.payload);
        })

    }
})
export const { changeStatusAddTraining } = trainingSlice.actions;
export default trainingSlice.reducer;