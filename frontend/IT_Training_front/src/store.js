import { configureStore } from "@reduxjs/toolkit";
import themeSlice from "./components/theme/themeSlice";
import trainingSlice from "./components/training/trainingSlice";
import testUserSlice from "./components/testUser/testUserSlice"

export default configureStore({
    reducer: {
        theme: themeSlice,
        training: trainingSlice,
        testUser: testUserSlice
    }
})