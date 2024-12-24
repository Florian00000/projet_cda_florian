export const parseDate = (dateString) => {
    const [day, month, year] = dateString.split('/');
    return new Date(`${year}-${month}-${day}`)
}

export const getPlanningOfWeek = (courses) => {
    const planning = new Set();
    return courses.filter(course => {
        const dayName = new Intl.DateTimeFormat('fr-FR', { weekday: 'long' }).format(parseDate(course.date))

        if (!planning.has(dayName)) {
            planning.add(dayName)
            return true;
        }
        return false
    });
}

export const formatDateToFrench = (dateString) => {
    const date = new Date(dateString);
    return new Intl.DateTimeFormat('fr-FR', {
        dateStyle: 'long',
        timeStyle: 'short',
    }).format(date);
};