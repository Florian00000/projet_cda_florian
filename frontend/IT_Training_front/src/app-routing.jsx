import {createBrowserRouter} from "react-router-dom"
import App from "./App"
import ErrorPage from "./components/shared/ErrorPage";
import HomeTheme from "./components/theme/HomeTheme";
import TrainingDetail from "./components/training/TrainingDetail";
import TestUser from "./components/testUser/TestUser";
import ResultTest from "./components/testUser/ResultTest";

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
            {path: "/training/testUser/:idTestUser", element: <TestUser/>},
            {path: "/training/testUser/result", element: <ResultTest/>}
        ]
    }
]);

export default router