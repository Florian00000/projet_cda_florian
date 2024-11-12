import {createBrowserRouter} from "react-router-dom"
import App from "./App"
import ErrorPage from "./components/shared/ErrorPage";
import HomeTheme from "./components/theme/HomeTheme";
import TrainingDetail from "./components/training/TrainingDetail";
import TestUser from "./components/testUser/TestUser";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        errorElement: <ErrorPage/>,
        children: [
            {
                path: "/",
                element: <HomeTheme/>
            },
            {
                path: "/:idList", element: <HomeTheme/>
            },
            {path: "/training/:idTraining", element: <TrainingDetail/>},
            {path: "/training/prérequis/:idTestUSer", element: <TestUser/>}
        ]
    }
]);

export default router