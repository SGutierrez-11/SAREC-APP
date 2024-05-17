import * as React from 'react';
import { IconSvgProps } from '@/types';

export const Logo: React.FC<IconSvgProps> = ({
  size = 36,
  width,
  height,
  ...props
}) => (
  <svg
    fill="none"
    height={size || height}
    viewBox="0 0 32 32"
    width={size || width}
    {...props}
  >
    <path
      clipRule="evenodd"
      d="M17.6482 10.1305L15.8785 7.02583L7.02979 22.5499H10.5278L17.6482 10.1305ZM19.8798 14.0457L18.11 17.1983L19.394 19.4511H16.8453L15.1056 22.5499H24.7272L19.8798 14.0457Z"
      fill="currentColor"
      fillRule="evenodd"
    />
  </svg>
);

export const DiscordIcon: React.FC<IconSvgProps> = ({
  size = 24,
  width,
  height,
  ...props
}) => {
  return (
    <svg
      height={size || height}
      viewBox="0 0 24 24"
      width={size || width}
      {...props}
    >
      <path
        d="M14.82 4.26a10.14 10.14 0 0 0-.53 1.1 14.66 14.66 0 0 0-4.58 0 10.14 10.14 0 0 0-.53-1.1 16 16 0 0 0-4.13 1.3 17.33 17.33 0 0 0-3 11.59 16.6 16.6 0 0 0 5.07 2.59A12.89 12.89 0 0 0 8.23 18a9.65 9.65 0 0 1-1.71-.83 3.39 3.39 0 0 0 .42-.33 11.66 11.66 0 0 0 10.12 0q.21.18.42.33a10.84 10.84 0 0 1-1.71.84 12.41 12.41 0 0 0 1.08 1.78 16.44 16.44 0 0 0 5.06-2.59 17.22 17.22 0 0 0-3-11.59 16.09 16.09 0 0 0-4.09-1.35zM8.68 14.81a1.94 1.94 0 0 1-1.8-2 1.93 1.93 0 0 1 1.8-2 1.93 1.93 0 0 1 1.8 2 1.93 1.93 0 0 1-1.8 2zm6.64 0a1.94 1.94 0 0 1-1.8-2 1.93 1.93 0 0 1 1.8-2 1.92 1.92 0 0 1 1.8 2 1.92 1.92 0 0 1-1.8 2z"
        fill="currentColor"
      />
    </svg>
  );
};

export const TwitterIcon: React.FC<IconSvgProps> = ({
  size = 24,
  width,
  height,
  ...props
}) => {
  return (
    <svg
      height={size || height}
      viewBox="0 0 24 24"
      width={size || width}
      {...props}
    >
      <path
        d="M19.633 7.997c.013.175.013.349.013.523 0 5.325-4.053 11.461-11.46 11.461-2.282 0-4.402-.661-6.186-1.809.324.037.636.05.973.05a8.07 8.07 0 0 0 5.001-1.721 4.036 4.036 0 0 1-3.767-2.793c.249.037.499.062.761.062.361 0 .724-.05 1.061-.137a4.027 4.027 0 0 1-3.23-3.953v-.05c.537.299 1.16.486 1.82.511a4.022 4.022 0 0 1-1.796-3.354c0-.748.199-1.434.548-2.032a11.457 11.457 0 0 0 8.306 4.215c-.062-.3-.1-.611-.1-.923a4.026 4.026 0 0 1 4.028-4.028c1.16 0 2.207.486 2.943 1.272a7.957 7.957 0 0 0 2.556-.973 4.02 4.02 0 0 1-1.771 2.22 8.073 8.073 0 0 0 2.319-.624 8.645 8.645 0 0 1-2.019 2.083z"
        fill="currentColor"
      />
    </svg>
  );
};

export const GithubIcon: React.FC<IconSvgProps> = ({
  size = 24,
  width,
  height,
  ...props
}) => {
  return (
    <svg
      height={size || height}
      viewBox="0 0 24 24"
      width={size || width}
      {...props}
    >
      <path
        clipRule="evenodd"
        d="M12.026 2c-5.509 0-9.974 4.465-9.974 9.974 0 4.406 2.857 8.145 6.821 9.465.499.09.679-.217.679-.481 0-.237-.008-.865-.011-1.696-2.775.602-3.361-1.338-3.361-1.338-.452-1.152-1.107-1.459-1.107-1.459-.905-.619.069-.605.069-.605 1.002.07 1.527 1.028 1.527 1.028.89 1.524 2.336 1.084 2.902.829.091-.645.351-1.085.635-1.334-2.214-.251-4.542-1.107-4.542-4.93 0-1.087.389-1.979 1.024-2.675-.101-.253-.446-1.268.099-2.64 0 0 .837-.269 2.742 1.021a9.582 9.582 0 0 1 2.496-.336 9.554 9.554 0 0 1 2.496.336c1.906-1.291 2.742-1.021 2.742-1.021.545 1.372.203 2.387.099 2.64.64.696 1.024 1.587 1.024 2.675 0 3.833-2.33 4.675-4.552 4.922.355.308.675.916.675 1.846 0 1.334-.012 2.41-.012 2.737 0 .267.178.577.687.479C19.146 20.115 22 16.379 22 11.974 22 6.465 17.535 2 12.026 2z"
        fill="currentColor"
        fillRule="evenodd"
      />
    </svg>
  );
};

export const MoonFilledIcon = ({
  size = 24,
  width,
  height,
  ...props
}: IconSvgProps) => (
  <svg
    aria-hidden="true"
    focusable="false"
    height={size || height}
    role="presentation"
    viewBox="0 0 24 24"
    width={size || width}
    {...props}
  >
    <path
      d="M21.53 15.93c-.16-.27-.61-.69-1.73-.49a8.46 8.46 0 01-1.88.13 8.409 8.409 0 01-5.91-2.82 8.068 8.068 0 01-1.3-8.61 8.391 8.391 0 018.62-1.31 8.38 8.38 0 013.02 3.04 8.375 8.375 0 01-1.8 9.14z"
      fill="currentColor"
    />
  </svg>
);

export const SunFilledIcon = ({
  size = 24,
  width,
  height,
  ...props
}: IconSvgProps) => (
  <svg
    aria-hidden="true"
    focusable="false"
    height={size || height}
    role="presentation"
    viewBox="0 0 24 24"
    width={size || width}
    {...props}
  >
    <path
      d="M12 7a5 5 0 110 10 5 5 0 010-10zM12 2a1 1 0 110 2 7 7 0 000 14 1 1 0 110 2 9 9 0 010-18z"
      fill="currentColor"
    />
  </svg>
);

export const EyeSlashFilledIcon = ({
  size = 24,
  width,
  height,
  ...props
}: IconSvgProps) => (
  <svg
    aria-hidden="true"
    focusable="false"
    height={size || height}
    role="presentation"
    viewBox="0 0 24 24"
    width={size || width}
    {...props}
  >
    <path
      d="M12 5c3.91 0 7.529 2.148 9.416 5.596l-1.43 1.43A7.956 7.956 0 0112 7a8.022 8.022 0 00-6.898 3.932l-1.587 1.587-1.295 1.295-1.57 1.57A1.25 1.25 0 002 15.75V15v-.75c0-1.77 1.45-3.22 3.22-3.22l1.5 1.5.362.362.644.644L6.22 15.28l-1.57 1.57 1.465 1.465 1.664 1.664 5.468 5.469C13.1 22.948 12.57 23 12 23c-4.418 0-8-3.582-8-8s3.582-8 8-8zM6 9.268A6.002 6.002 0 016.22 7.5l9.83 9.83a6 6 0 01-9.83-9.83z"
      fill="currentColor"
    />
  </svg>
);

export const EyeFilledIcon = ({
  size = 24,
  width,
  height,
  ...props
}: IconSvgProps) => (
  <svg
    aria-hidden="true"
    focusable="false"
    height={size || height}
    role="presentation"
    viewBox="0 0 24 24"
    width={size || width}
    {...props}
  >
    <path
      d="M12 4c-2.028 0-3.89.88-5.19 2.29l1.44 1.43c.736-.73 1.74-1.18 2.85-1.18 2.21 0 4 1.79 4 4s-1.79 4-4 4c-1.1 0-2.1-.45-2.84-1.17l-1.44 1.44C8.11 18.13 9.97 19 12 19c3.314 0 6-2.686 6-6s-2.686-6-6-6zm-6 6c0-.52.14-1 .37-1.43l1.57 1.57c-.27.24-.49.52-.66.86l-1.44-1.44zm5.63 3.29c.24.25.52.47.86.64l-1.57 1.57a5.98 5.98 0 01-1.28-1.63l1.44-1.44zM12 7c-1.11 0-2.12.45-2.85 1.18l-1.44-1.43A7.98 7.98 0 0112 5c1.3 0 2.49.31 3.56.83l-1.56 1.56c-.51-.19-1.06-.31-1.63-.31zm3.63 3.29c.51.19 1.06.31 1.63.31 1.66 0 3 1.34 3 3s-1.34 3-3 3c-.57 0-1.11-.12-1.61-.33l1.55-1.55c.27-.24.49-.52.66-.86l1.56 1.56c-.42.33-.93.56-1.49.67-.04-.28-.12-.56-.27-.82l-1.57-1.57zM12 16c-1.3 0-2.49-.31-3.56-.83l1.56-1.56c.51.19 1.06.31 1.63.31 1.66 0 3-1.34 3-3s-1.34-3-3-3c-.57 0-1.11.12-1.61.33l-1.56-1.56c.42-.33.93-.56 1.49-.67.04.28.12.56.27.82l1.57 1.57c.26.24.52.48.78.7l1.56 1.56c-.32.23-.67.41-1.04.54l-1.43-1.43c.27-.15.52-.34.74-.56l1.43-1.43c.57.33 1.22.53 1.92.53 2.21 0 4-1.79 4-4s-1.79-4-4-4c-1.29 0-2.45.61-3.2 1.56l-1.4-1.4C8.59 5.38 10.24 5 12 5c3.314 0 6 2.686 6 6s-2.686 6-6 6z"
      fill="currentColor"
    />
  </svg>
);
export const SearchIcon = ({
  size = 24,
  width,
  height,
  ...props
}: IconSvgProps) => (
  <svg
    aria-hidden="true"
    focusable="false"
    height={size || height}
    role="presentation"
    viewBox="0 0 24 24"
    width={size || width}
    {...props}
  >
    <path
      d="M21 21l-4.35-4.35"
      fill="none"
      stroke="currentColor"
      strokeLinecap="round"
      strokeLinejoin="round"
      strokeWidth="2"
    />
    <circle
      cx="10.5"
      cy="10.5"
      r="7.5"
      fill="none"
      stroke="currentColor"
      strokeLinecap="round"
      strokeLinejoin="round"
      strokeWidth="2"
    />
  </svg>
);