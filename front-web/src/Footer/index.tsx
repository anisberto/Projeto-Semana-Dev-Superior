import './style.css';
import { ReactComponent as Instagram } from './Instagram.svg';
import { ReactComponent as Linkedin } from './Linkedin.svg';
import { ReactComponent as YouTube } from './Youtube.svg';

function Footer() {
    return (
        <footer className="main-footer">
            <h3>App desenvolvido durante a 2ª ed. do evento Semana DevSuperior</h3>
            <div className="footer-icons">
                <a href="https://www.youtube.com/c/devsuperior" target="blanck">
                    <YouTube />
                </a>
                <a href="https://www.linkedin.com/in/anisberto/" target="blanck">
                    <Linkedin />
                </a>
                <a href="https://www.instagram.com/anisberto_reis/" target="blanck">
                    <Instagram />
                </a>
            </div>
        </footer>
    )
}

export default Footer;