import { createBrowserRouter } from "react-router-dom"
import App from "./App"
import ErrorPage from "./components/shared/ErrorPage";
import HomeTheme from "./components/theme/HomeTheme";
import TrainingDetail from "./components/training/TrainingDetail";
import TestUser from "./components/testUser/TestUser";
import ResultTest from "./components/testUser/ResultTest";
import TrainingForm from "./components/training/TrainingForm";
import AuthenticationForm from "./components/shared/authentication/AuthenticationForm";
import ProtectedPathAdmin from "./components/shared/authentication/ProtectedPathAdmin";
import ProtectedPath from "./components/shared/authentication/ProtectedPath";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
        errorElement: <ErrorPage />,
        children: [
            {
                path: "/",
                element: <HomeTheme />
            },
            {
                path: "/:idList", element: <HomeTheme />
            },
            { path: "/training/:idTraining", element: <TrainingDetail /> },
            {
                path: "/training/testUser/:idTestUser",
                element: <ProtectedPath><TestUser /></ProtectedPath>
            },
            {
                path: "/training/testUser/result",
                element: <ProtectedPath><ResultTest /></ProtectedPath>
            },
            {
                path: "/training/admin/addTraining",
                element: 
                <ProtectedPathAdmin>
                    <TrainingForm />
                </ProtectedPathAdmin>
            },
            { path: "/authentication", element: <AuthenticationForm /> }
        ]
    }
]);

export default router