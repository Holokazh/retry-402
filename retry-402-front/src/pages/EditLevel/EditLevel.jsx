import { useState } from 'react';
import { useParams } from "react-router";
import { useFetch } from '../../hooks/useFetch';


function EditLevel() {
    const { id } = useParams();
    const [url, setUrl] = useState(`http://127.0.0.1:8080/api/levels/${id}`);
    const { data, isPending, error } = useFetch(url);

    // console.log(data);

    return (
        <div className="App">
            {isPending && <div>Loading....</div>}
            {error && <div>{error}</div>}
            {data &&
                <h1 key={data.id}>{data.name}</h1>
            }
        </div>
    );
}

export default EditLevel