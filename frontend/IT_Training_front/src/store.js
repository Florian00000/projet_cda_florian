import { configureStore } from "@reduxjs/toolkit";
import themeSlice from "./components/theme/themeSlice";
import trainingSlice from "./components/training/trainingSlice";
import testUserSlice from "./components/testUser/testUserSlice"
import authenticationSlice from "./components/shared/authentication/authenticationSlice"

export default configureStore({
    reducer: {
        theme: themeSlice,
        training: trainingSlice,
        testUser: testUserSlice,
        authentication: authenticationSlice
    }
})