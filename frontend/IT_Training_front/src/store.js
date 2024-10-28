import { configureStore } from "@reduxjs/toolkit";
import themeSlice from "./components/theme/themeSlice";

export default configureStore({
    reducer: {
        theme: themeSlice
    }
})