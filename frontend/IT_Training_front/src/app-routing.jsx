import {createBrowserRouter} from "react-router-dom"
import App from "./App"
import ErrorPage from "./components/shared/ErrorPage";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        errorElement: <ErrorPage/>,
        children: []
    }
]);

export default router