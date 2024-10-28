import {createBrowserRouter} from "react-router-dom"
import App from "./App"
import ErrorPage from "./components/shared/ErrorPage";
import HomeTheme from "./components/theme/HomeTheme";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        errorElement: <ErrorPage/>,
        children: [
            {
                path: "/",
                element: <HomeTheme/>
            }
        ]
    }
]);

export default router