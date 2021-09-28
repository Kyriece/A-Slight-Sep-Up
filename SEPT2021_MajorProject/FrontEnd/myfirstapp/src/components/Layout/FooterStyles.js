import styled from 'styled-components';

export const Box = styled.div`
padding: 5px 10px;
position: fixed;
bottom: 0;
width: 100%;
height: 135px;
margin-bottom: -50px;
background-color: white;

border-top: 0.20px solid grey;


@media (max-width: 1000px) {
	padding: 70px 30px;
}
`;

export const Container = styled.div`
	display: flex;
	flex-direction: column;
	justify-content: center;
	max-width: 1000px;
	margin: 0 auto;
`

export const Column = styled.div`
display: flex;
flex-direction: column;
text-align: left;
margin-left: 1rem;
`;

export const Row = styled.div`
display: grid;
grid-template-columns: repeat(auto-fill,
						minmax(185px, 1fr));
grid-gap: 5px;

@media (max-width: 1000px) {
	grid-template-columns: repeat(auto-fill,
						minmax(200px, 1fr));
}
`;

export const FooterLink = styled.a`
color: black;
margin-bottom: 5px;
font-size: 12px;
text-decoration: none;

&:hover {
	color: pink;
	transition: 200ms ease-in;
}
`;

export const Heading = styled.p`
font-size: 15px;
color: black;
margin-bottom: 5px;
font-weight: bold;
`;

export const Rights = styled.div`
color: black;
width: 40%;
margin: 1px;
position: absolute;
right: 0;
`
