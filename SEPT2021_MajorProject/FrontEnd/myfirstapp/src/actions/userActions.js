import axios from "axios";

export async function getUser(id) {
    try {
        const res = await axios.get(`/api/user/${id}`);
        return res.data;
    } catch (error) {
        console.log("error in user fetch");
    }
};
