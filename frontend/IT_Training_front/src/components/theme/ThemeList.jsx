import ThemeCube from './ThemeCube';
import classes from './Theme.module.css'
import { useNavigate, useSearchParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { searchTraining } from './themeSlice';

const ThemeList = () => {
    const [searchParams, setSearchParams] = useSearchParams();
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const mode = searchParams.get("mode") ?? "theme";
    const list = useSelector((state) => state.theme.list);
    const searchQuery = useSelector((state) => state.theme.searchQuery);

    const linkTo = (id) => {
        if (searchQuery) {
            dispatch(searchTraining(""))
            navigate(`/training/${id}`)
        } else {
            switch (mode) {
                case "theme":
                    navigate(`/${id}?mode=subtheme`)
                    break;
                case "subtheme":
                    navigate(`/${id}?mode=training`)
                    break;
                case "training":
                    navigate(`/training/${id}`)
                    break;
                default:
                    navigate("/")
                    break;
            }
        }

    }

    const filteredList = searchQuery ? list.filter(theme => theme.title.toLowerCase().includes(searchQuery.toLowerCase())) : list

    return (
        <section className={classes.list}>
            {filteredList.map((theme, index) => (
                <ThemeCube key={index} theme={theme} onClick={() => linkTo(theme.id)} />

            ))}
        </section>
    );
}

export default ThemeList;
